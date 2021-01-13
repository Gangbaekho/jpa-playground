package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class ChannelRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Channel> findAll(){

//        일반적인 JPQL을 쓴 모습이다.
        Query query = entityManager.createQuery("select c from Channel c");
        List<Channel> channelList = query.getResultList();
        return channelList;
    }

    public void saveChannel(Channel channel){
        if(Objects.isNull(channel.getId())){
            entityManager.persist(channel);
        }else{
            entityManager.merge(channel);
        }
    }

    public Channel findById(Long id){

        Channel selectedChannel = entityManager.find(Channel.class,id);
        return selectedChannel;
    }
}
