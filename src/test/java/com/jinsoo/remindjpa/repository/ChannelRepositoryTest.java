package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.Channel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChannelRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelRepositoryTest.class);

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    public void saveChannel(){

        Channel insertedChannel = new Channel();
        insertedChannel.setChannelName("dummy channel");
        insertedChannel.setId(1L);

        channelRepository.saveChannel(insertedChannel);
        LOGGER.info("insert channel successful!");

        Channel selectedChannel = channelRepository.findById(1L);
        LOGGER.info("selected channel ==> {}",selectedChannel);
    }

    @Test
    public void findAllChannelTest(){

        Channel insertedChannelOne = new Channel();
        insertedChannelOne.setChannelName("dummy channel one");
        insertedChannelOne.setId(1L);
        channelRepository.saveChannel(insertedChannelOne);

        Channel insertedChannelTwo = new Channel();
        insertedChannelTwo.setChannelName("dummy channel two");
        insertedChannelTwo.setId(2L);
        channelRepository.saveChannel(insertedChannelTwo);

        List<Channel> allChannels = channelRepository.findAll();
        LOGGER.info("Channel counts : {}", allChannels.size());
        for(Channel c : allChannels){
            LOGGER.info("selected Channel ==> {}",c);
        }
    }

}
