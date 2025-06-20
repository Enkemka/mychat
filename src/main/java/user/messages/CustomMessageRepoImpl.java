package user.messages;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;



@Repository
public class CustomMessageRepoImpl implements CustomMessageRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UpdateResult editMessage(String messageLogId,String messageId, String newContentString) {
        Query query = new Query(Criteria.where("_id").is(messageLogId)
        .and("messageId").is(messageId));

        /*Look inside an array called messageHistory.
        Each item in that array has an _id.
        I want to find the document where one of those _ids equals messageId.*/


        Update update = new Update().set("messageHistory.$.content", newContentString);

       /* building an “update command” for MongoDB.
         It says: “Once you find that message, change its (content) to the new message.”
        The $ symbol is special — it means “the exact message that matched your search.”*/


      return  mongoTemplate.updateFirst(query, update, MessageLog.class);

       /* It sends the search and update to MongoDB.

It looks for the first MessageLog document that matches your query.

Then it updates that specific message inside it.

Breakdown:

query: What you're looking for.

update: What you want to change.

MessageLog.class: Tells MongoDB what kind of document you’re working with.*/
    }


    @Override
    public UpdateResult deleteMessage(String messageLogId,String messageId){
        Query query = new Query(Criteria.where("_id").is(messageId)
                .and("messageId").is(messageId));

        Update update = new Update().pull("messageHistory",Query.query(Criteria.where("_id").is(messageId)));
       return mongoTemplate.updateFirst(query, update, MessageLog.class);
    }

    @Override
    public UpdateResult addMessage(String messageLogId , Message newContentString ){
        Query query = new Query(Criteria.where("_id").is(messageLogId));
        Update update = new Update().push("messageHistory", newContentString);
     return   mongoTemplate.updateFirst(query, update, MessageLog.class);





    }

}