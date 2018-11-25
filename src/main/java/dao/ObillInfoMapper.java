package dao;

import model.ObillInfo;

public interface ObillInfoMapper {
    int deleteByPrimaryKey(Integer obill);

    int insert(ObillInfo record);

    int insertSelective(ObillInfo record);

    ObillInfo selectByPrimaryKey(Integer obill);

    int updateByPrimaryKeySelective(ObillInfo record);

    int updateByPrimaryKey(ObillInfo record);
}