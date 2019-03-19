package com.watchingy.dao;

import com.watchingy.model.StudentAppInfo;
import com.watchingy.vo.StudentAppInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAppInfoDao {

    void add(StudentAppInfo studentAppInfo);

    List<StudentAppInfoVo> getByClassId(int classId);

    String getBySid(int sid);

    List<StudentAppInfo> getByUidAndClassId(@Param("uid") int uid , @Param("classId") int classId);
}
