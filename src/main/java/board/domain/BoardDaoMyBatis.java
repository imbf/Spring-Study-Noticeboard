package board.domain;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoMyBatis implements BoardDao{
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired // sqlSessionTemplate Bean주입 (Sql을 맵핑하는 클라이언트를 설정하는 Autowired Setter이다.)
    public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<BoardDTO> list() {
        // 인자로써 SQL 스크립트 파일에 명시된 id를 준다.
        return sqlSessionTemplate.selectList("list");
    }

    @Override
    public int delete(BoardDTO boardDTO) {
        // 인자로써 SQL 스크립트 파일에 명시된 id와 parameterType의 객체를 준다.
        return sqlSessionTemplate.delete("delete", boardDTO);
    }

    @Override
    public int deleteAll() {
        return sqlSessionTemplate.delete("deleteAll");
    }

    @Override
    public int update(BoardDTO boardDTO) {
        return sqlSessionTemplate.update("update", boardDTO);
    }

    @Override
    public int insert(BoardDTO boardDTO) {
        return sqlSessionTemplate.insert("insert", boardDTO);
    }

    @Override
    public BoardDTO select(int seq) {
        // BoardDao에서 seq를 사용해서 BoardDTO를 select한다.
        return sqlSessionTemplate.selectOne("select", seq);
    }

    @Override
    public int updateReadCount(int seq) {
        return sqlSessionTemplate.update("updateCount", seq);
    }
}
