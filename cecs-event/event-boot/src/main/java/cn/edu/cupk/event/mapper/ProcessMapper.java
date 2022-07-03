package cn.edu.cupk.event.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcessMapper {
    //插入
    Boolean insertNewOne(long eventId);

    Boolean insertOne(long eventId);

    Integer findEndNode(long eventId);

    //通过事件id获取进程id
//    Integer getIDByEventId(long eventId);
    //查询是否存在前置节点
    Integer acquireNumOfEvent(long eventId);

    Integer updateStatus(Integer processId);

    Integer fillNextNode(Integer processId,Integer newNode);
}
