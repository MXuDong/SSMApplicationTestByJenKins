package dao;

import model.ObillInfo;

import java.util.List;

public interface ObillInfoMapper {

    int insert(ObillInfo record);

    ObillInfo selectByPrimaryKey(Integer obill);

    List<ObillInfo> selectAllOrderByTimeDesc();
}