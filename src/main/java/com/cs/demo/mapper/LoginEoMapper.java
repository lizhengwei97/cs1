package com.cs.demo.mapper;

import com.cs.demo.eo.LoginEo;
import com.cs.demo.eo.LoginEoExample;
import com.cs.demo.eo.LoginEoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginEoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    long countByExample(LoginEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int deleteByExample(LoginEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int deleteByPrimaryKey(LoginEoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int insert(LoginEo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int insertSelective(LoginEo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    List<LoginEo> selectByExample(LoginEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    LoginEo selectByPrimaryKey(LoginEoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int updateByExampleSelective(@Param("record") LoginEo record, @Param("example") LoginEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int updateByExample(@Param("record") LoginEo record, @Param("example") LoginEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int updateByPrimaryKeySelective(LoginEo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_login
     *
     * @mbg.generated Tue Apr 20 10:22:58 CST 2021
     */
    int updateByPrimaryKey(LoginEo record);
}