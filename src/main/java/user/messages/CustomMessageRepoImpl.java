package user.messages;

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
    public void editMessage(String messageId, String newContent) {
        Query query = new Query(Criteria.where("messageHistory._id").is(messageId));

        /*Look inside an array called messageHistory.
        Each item in that array has an _id.
        I want to find the document where one of those _ids equals messageId.*/


        Update update = new Update().set("messageHistory.$.content", newContent);

       /* building an “update command” for MongoDB.
         It says: “Once you find that message, change its (content) to the new message.”
        The $ symbol is special — it means “the exact message that matched your search.”*/


        mongoTemplate.updateFirst(query, update, MessageLog.class);

       /* It sends the search and update to MongoDB.

It looks for the first MessageLog document that matches your query.

Then it updates that specific message inside it.

Breakdown:

query: What you're looking for.

update: What you want to change.

MessageLog.class: Tells MongoDB what kind of document you’re working with.*/
    }


    @Override
    public void deleteMessage(String messageId){
        Query query = new Query(Criteria.where("messageHistory._id").is(messageId));
        Update update = new Update().pull("messageHistory",Query.query(Criteria.where("_id").is(messageId)));
        mongoTemplate.updateFirst(query, update, MessageLog.class);
    }

}