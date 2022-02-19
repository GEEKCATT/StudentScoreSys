package com.chn.StudentScoreSys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chn.StudentScoreSys.entity.ABC;
import com.chn.StudentScoreSys.entity.Score;


public class ScoreDao extends BaseDao {
	public Score selectBySidAndCid(int Sid,int Cid) {
		Score score = null;
		String sql = "select * from s_score where Sid=? and Cid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Sid);
			pst.setInt(2, Cid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			if(rs.next()){
				score = new Score(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}

	public ArrayList<ABC> selectAllScore() {
		ABC abc = null;
		ArrayList<ABC> list= new ArrayList<ABC>();
		String sql = "select Sname,Cname,Tname,score from s_score t1,student t2,teacher t3,course t4 "
				+ "where t1.Sid=t2.Sid and t1.Cid=t4.Cid and t1.Tid=t3.Tid";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				abc = new ABC(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				list.add(abc);
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	public ArrayList<Score> selectAllBySid(int Sid) {
		Score score = null;
		ArrayList<Score> list= new ArrayList<Score>();
		String sql = "select * from s_score where Sid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Sid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				score = new Score(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				list.add(score);
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	public ArrayList<Score> selectAllByCid(int Cid) {
		Score score = null;
		ArrayList<Score> list= new ArrayList<Score>();
		String sql = "select * from s_score where Cid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Cid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				score = new Score(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				list.add(score);
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	public ArrayList<Score> selectAllByTid(int Tid) {
		Score score = null;
		ArrayList<Score> list= new ArrayList<Score>();
		String sql = "select * from s_score where Tid=?";
		try {
			//通过连接对象获得语句对象
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Tid);
			//执行sql语句   结果集
			ResultSet rs = pst.executeQuery();
			//判断结果集是否有值
			while(rs.next()){
				score = new Score(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				list.add(score);
			}
			//关闭资源
			rs.close();
			pst.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	public int updateScore(Score score) {
		int num = 0;
		String sql = "update s_score set Tid=?,Score=? where Sid=? and Cid=?";//用null是因为数据表中选择了自增
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, score.getTid());
			pst.setInt(2, score.getValue());
			pst.setInt(3, score.getSid());
			pst.setInt(4, score.getCid());
			//执行sql语句
			num = pst.executeUpdate();
			System.out.println("修改了"+num+"条数据");
			//关闭资源
			pst.close();
			closeConn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int insertScore(int Sid,int Cid,int Tid,int score){
		int num = 0;
		String sql = "insert into s_score values(?,?,?,?)";//用null是因为数据表中选择了自增
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1, Sid);
			pst.setInt(2, Cid);
			pst.setInt(3, Tid);
			pst.setInt(4, score);
			//执行sql语句
			num = pst.executeUpdate();
			System.out.println("添加了"+num+"条数据");
			//关闭资源
			pst.close();
			closeConn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int deleteBySidAndCid(int Sid,int Cid){
		int num = 0;
		
		String sql = "delete from s_score where Sid=? and Cid=?";
		//通过连接对象获得语句对象
		try {
			PreparedStatement pst = getConn().prepareStatement(sql);
			//执行之前补全sql语句
			pst.setInt(1,Sid);
			pst.setInt(2,Cid);
			//执行sql语句
			num = pst.executeUpdate();
			System.out.println("删除了"+num+"条数据");
			//关闭资源
			pst.close();
			closeConn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ScoreDao scoredao= new ScoreDao();
//		Score score = scoredao.selectBySidAndCid(1, 1);
//		System.out.println(score);
//		
//		scoredao.insertScore(2, 2, 2, 61);
		System.out.println(scoredao.selectAllScore().toString());
		//scoredao.deleteBySidAndCid(2, 2);
	}

}

