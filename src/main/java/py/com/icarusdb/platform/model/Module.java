package py.com.icarusdb.platform.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * @author Roberto Gamarra [icarusdb@gmail.com]
 */
@Entity
@Table(name = "MODULE", schema = "public")
@NamedQuery(name = "Module.findAll",
            query = "select m from Module m order by m.id")
@NamedQuery(name = "Module.findAllActives",
            query = "select m from Module m where m.activo = :activo ")
public class Module implements Serializable {

    private static final long serialVersionUID = -3024834661766008702L;

    @Id
    @SequenceGenerator(name = "MODULE_ID_GENERATOR", schema = "public",
                       sequenceName = "public.MODULE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODULE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column
    private boolean active;

    @Column(nullable = false)
    @NotNull
    private String description;

    @Column
    private Long orden;

    private String iconName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean activo) {
        this.active = activo;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, description, iconName, id, name, orden);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Module)) {
            return false;
        }
        Module other = (Module) obj;
        return active == other.active && Objects.equals(description, other.description)
            && Objects.equals(iconName, other.iconName) && Objects.equals(id, other.id)
            && Objects.equals(name, other.name) && Objects.equals(orden, other.orden);
    }

}
