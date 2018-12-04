package dao;

import model.LogObillOperation;

import java.util.List;

public interface LogObillOperationMapper {
    List<LogObillOperation> selectById(int looId);
    int insert(LogObillOperation logObillOperation);
}
