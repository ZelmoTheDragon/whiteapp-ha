package com.github.zelmothedragon.whiteapp.domain.util.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Génère une validation d'objet. Cette classe est immuable.
 *
 * @author MOSELLE Maxime
 * @param <T> Type de l'objet à valider
 */
public final class Validator<T> {

    /**
     * Instance à valider.
     */
    private final T element;

    /**
     * Exceptions accumulées.
     */
    private final List<ValidationException> exceptions;

    /**
     * Constructeur. Ce constructeur est privé, afin de faciliter l'emploi de
     * cette classe, utiliser la méthode <code>of</code> et chaîner les appels
     * de méthodes.
     *
     * @param element Instance à valider
     * @param exceptions Liste des exceptions accumulées
     */
    private Validator(final T element, final List<ValidationException> exceptions) {
        this.element = element;
        this.exceptions = List.copyOf(exceptions);
    }

    /**
     * Point d'entrée de cette classe pour commencer à construire le calcul de
     * la validation de l'objet.
     *
     * @param <E> Type de l'objet à valider
     * @param element Instance à valider
     * @return Une instance de cette classe afin de chaîner les appels de
     * méthodes
     */
    public static <E> Validator<E> of(final E element) {
        return new Validator<>(
                Objects.requireNonNull(element),
                List.of()
        );
    }

    /**
     * Ajouter un prédicat de validation.
     *
     * @param validation Un prédicat
     * @param attribut Nom de l'attribut à valider
     * @param message Un message en cas d'échec de la validation
     * @return L'instance de cette classe afin de chaîner les appels de méthodes
     */
    public Validator<T> validate(
            final Predicate<T> validation,
            final String attribut,
            final String message) {

        // XXX.getEmail() != null
        // customer.getr
        
        final List<ValidationException> copy;
        if (!validation.test(element)) {
            var ex = new ValidationException(attribut, message);
            copy = new ArrayList<>(exceptions);
            copy.add(ex);
        } else {
            copy = List.copyOf(exceptions);
        }
        return new Validator<>(element, copy);
    }

    /**
     * Ajouter un prédicat de validation.
     *
     * @param <U> Type de retour de l'accesseur
     * @param getter Un accesseur
     * @param validation Un prédicat
     * @param attribut Nom de l'attribut à valider
     * @param message Un message en cas d'échec de la validation
     * @return L'instance de cette classe afin de chaîner les appels de méthodes
     */
    public <U> Validator<T> validate(
            final Function<T, U> getter,
            final Predicate<U> validation,
            final String attribut,
            final String message) {

        // XXX.getEmail() != null
        
        return validate(getter.andThen(validation::test)::apply, attribut, message);
    }

    /**
     * Opération de terminaison, résout le calcul de la validation.
     *
     * @return L'instance de l'objet a valider
     */
    public T get() {
        if (!exceptions.isEmpty()) {
            var ex = new ValidationException(element.getClass());
            exceptions.forEach(ex::addSuppressed);
            throw ex;
        }
        return element;
    }

}
