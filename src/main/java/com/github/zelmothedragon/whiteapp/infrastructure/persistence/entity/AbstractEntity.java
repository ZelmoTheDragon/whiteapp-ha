package com.github.zelmothedragon.whiteapp.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MOSELLE Maxime
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonbTransient
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    protected UUID id;

    @NotNull
    @JsonbTransient
    @Version
    @Column(name = "version", nullable = false)
    protected Long version;

    protected AbstractEntity() {
        this.id = UUID.randomUUID();
        this.version = 0L;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }

    @Override
    public boolean equals(final Object obj) {
        final boolean eq;
        if (this == obj) {
            eq = true;
        } else if (!(obj instanceof AbstractEntity)) {
            eq = false;
        } else {
            final var other = (AbstractEntity) obj;
            eq = Objects.equals(id, other.id)
                    && Objects.equals(version, other.version);
        }
        return eq;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[%s]{version=%s}",
                getClass().getName(),
                id,
                version
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
