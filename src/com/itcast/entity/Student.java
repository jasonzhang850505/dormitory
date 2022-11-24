package com.itcast.entity;

/**
 * The type Student.
 */
public class Student {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer dormitoryID;
    private String dormitoryName;
    private String state;
    private String create_date;

    /**
     * Instantiates a new Student.
     */
    public Student() {
    }

    /**
     * Instantiates a new Student.
     *
     * @param id            the id
     * @param number        the number
     * @param name          the name
     * @param gender        the gender
     * @param dormitoryID   the dormitory id
     * @param dormitoryName the dormitory name
     * @param state         the state
     * @param create_date   the create date
     */
    public Student(Integer id, String number, String name, String gender, Integer dormitoryID, String dormitoryName, String state, String create_date) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.dormitoryID = dormitoryID;
        this.dormitoryName = dormitoryName;
        this.state = state;
        this.create_date = create_date;
    }

    /**
     *
     * @param id         the id
     * @param number     the number
     * @param name       the name
     * @param gender     the gender
     * @param dormitoryID the dormitoryID
     */
    public Student(Integer id, String number, String name, String gender, Integer dormitoryID) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.dormitoryID = dormitoryID;
    }

    /**
     * Instantiates a new Student.
     *
     * @param number      the number
     * @param name        the name
     * @param gender      the gender
     * @param dormitoryID the dormitory id
     * @param state       the state
     * @param create_date the create date
     */
    public Student(String number, String name, String gender, Integer dormitoryID, String state, String create_date) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.dormitoryID = dormitoryID;
        this.state = state;
        this.create_date = create_date;
    }

    /**
     * Instantiates a new Student.
     *
     * @param number      the number
     * @param name        the name
     * @param gender      the gender
     * @param dormitoryID the dormitory id
     */
    public Student(String number, String name, String gender, Integer dormitoryID) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.dormitoryID = dormitoryID;
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(String number) {
        this.number = number;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets dormitory id.
     *
     * @return the dormitory id
     */
    public Integer getDormitoryID() {
        return dormitoryID;
    }

    /**
     * Sets dormitory id.
     *
     * @param dormitoryID the dormitory id
     */
    public void setDormitoryID(Integer dormitoryID) {
        this.dormitoryID = dormitoryID;
    }

    /**
     * Gets dormitory name.
     *
     * @return the dormitory name
     */
    public String getDormitoryName() {
        return dormitoryName;
    }

    /**
     * Sets dormitory name.
     *
     * @param dormitoryName the dormitory name
     */
    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * Sets create date.
     *
     * @param create_date the create date
     */
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
