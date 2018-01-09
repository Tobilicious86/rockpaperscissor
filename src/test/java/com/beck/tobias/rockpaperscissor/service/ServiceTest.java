package com.beck.tobias.rockpaperscissor.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.repository.GameRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ServiceTest {

    @Autowired
    GameService service;

@Test
    public void test(){
    assertThat("Test").isEqualToIgnoringCase("test");
}

}
