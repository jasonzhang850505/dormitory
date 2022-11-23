package com.itcast.entity;

/**
 * The type Dormitory.
 */
public class Dormitory {
    private Integer id;
    private Integer buildingId;
    private String name;
    private Integer type;
    private Integer available;
    private String telephone;

    /**
     * Instantiates a new Dormitory.
     *
     * @param id         the id
     * @param buildingId the building id
     * @param name       the name
     * @param type       the type
     * @param available  the available
     * @param telephone  the telephone
     */
    public Dormitory(Integer id, Integer buildingId, String name, Integer type, Integer available, String telephone) {
        this.id = id;
        this.buildingId = buildingId;
        this.name = name;
        this.type = type;
        this.available = available;
        this.telephone = telephone;
    }

    /**
     * Instantiates a new Dormitory.
     *
     * @param id   the id
     * @param name the name
     */
    public Dormitory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets building id.
     *
     * @return the building id
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * Gets available.
     *
     * @return the available
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * Gets telephone.
     *
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets building id.
     *
     * @param buildingId the building id
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * Sets telephone.
     *
     * @param telephone the telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
