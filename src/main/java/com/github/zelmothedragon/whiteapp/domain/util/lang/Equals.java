package com.github.zelmothedragon.whiteapp.domain.util.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Génère le calcul de la méthode <code>equals</code> des objets en utilisant
 * une approche fonctionnelle. Lors de la redéfinition de la méthode
 * <code>equals</code>, il est également nécessaire de redéfinir la méthode
 * <code>hashCode</code>. La classe <code>java.util.Objects</code> propose déjà
 * une manière simple pour cette méthode. Cette classe est immuable.
 *
 * @param <T> Type quelconque
 * @author MOSELLE Maxime
 */
public final class Equals<T> {

    /**
     * Liste de fonctions utilisées pour la comparaison.
     */
    private final List<Function<T, ?>> methods;

    /**
     * Constructeur. Ce constructeur est privé, afin de faciliter l'emploi de
     * cette classe, utiliser la méthode <code>with</code> et chaîner les appels
     * de méthodes.
     *
     * @param methods Liste de fonctions utilisées pour la comparaison
     */
    private Equals(final List<Function<T, ?>> methods) {
        this.methods = List.copyOf(methods);
    }

    /**
     * Point d'entrée de cette classe pour commencer à construire le calcul de
     * l'égalité entre deux objets.
     *
     * @param <T> Type quelconque
     * @param method Une méthode de l'instance initiale, en général des
     * accesseurs sont employés
     * @return Une instance de cette classe afin de chaîner les appels de
     * méthodes
     */
    public static <T> Equals<T> with(final Function<T, ?> method) {
        return new Equals<>(List.of(method));
    }

    /**
     * Ajouter une méthode supplémentaire pour le calcul de l'égalité. L'appel
     * de cette méthode peut être chaîner autant de fois que nécessaire.
     *
     * @param method Une méthode de l'instance initiale, en général des
     * accesseurs sont employés
     * @return Une instance de cette classe afin de chaîner les appels de
     * méthodes
     */
    public Equals<T> thenWith(final Function<T, ?> method) {
        var copy = new ArrayList<>(methods);
        copy.add(method);
        return new Equals<>(copy);
    }

    /**
     * Opération de terminaison, résout le calcul de l'égalité.
     *
     * @param me Instance courante
     * @param target Enstance cible
     * @return La valeur <code>true</code> si les deux objets sont identiques,
     * sinon la valeur <code>false</code>
     */
    public boolean apply(final T me, final Object target) {
        boolean eq;
        if (me == target) {
            eq = true;
        } else if (!Objects.equals(me.getClass(), target.getClass())) {
            eq = false;
        } else {
            var other = (T) target;
            eq = methods
                    .stream()
                    .allMatch(p -> Objects.equals(p.apply(me), p.apply(other)));
        }
        return eq;
    }

}
