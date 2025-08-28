package com.mysite.sbb;

import com.mysite.sbb.article.Article;
import com.mysite.sbb.article.ArticleRepository;
import com.mysite.sbb.article.ArticleService;
import com.mysite.sbb.test.TestData;
import com.mysite.sbb.test.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    @Test
    void testJpa() {
        TestData test = new TestData();
        test.setDb("test용");

        this.testRepository.save(test);  // 첫번째 질문 저장

    }
    @Test
    void testJpa01(){
        Article a1 = new Article();
        //a1.setId(1);
        a1.setSubject("제목1");
        a1.setContent("내용1");
        a1.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(a1);
    }
//    @Test
//    void testJpa02() {
//        for (int i = 1; i <= 300; i++) {
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용무";
//            this.articleService.create(subject, content);
//        }
//    }

}

