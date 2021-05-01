package com.cs.demo.eo;

import java.io.Serializable;

public class CourseEoKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.id
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_course
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    public CourseEoKey(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    public CourseEoKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.id
     *
     * @return the value of tb_course.id
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.id
     *
     * @param id the value for tb_course.id
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CourseEoKey other = (CourseEoKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbg.generated Wed Apr 28 18:11:58 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}