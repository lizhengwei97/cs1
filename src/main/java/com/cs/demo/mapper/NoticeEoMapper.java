package com.cs.demo.mapper;

import com.cs.demo.eo.NoticeEo;
import com.cs.demo.eo.NoticeEoExample;
import com.cs.demo.eo.NoticeEoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeEoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    long countByExample(NoticeEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int deleteByExample(NoticeEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int deleteByPrimaryKey(NoticeEoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int insert(NoticeEo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int insertSelective(NoticeEo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    List<NoticeEo> selectByExample(NoticeEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    NoticeEo selectByPrimaryKey(NoticeEoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int updateByExampleSelective(@Param("record") NoticeEo record, @Param("example") NoticeEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int updateByExample(@Param("record") NoticeEo record, @Param("example") NoticeEoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int updateByPrimaryKeySelective(NoticeEo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_notice
     *
     * @mbg.generated Sat Apr 24 21:54:32 CST 2021
     */
    int updateByPrimaryKey(NoticeEo record);
}