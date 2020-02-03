# clean-architecture

PassEntering and PassExiting in the RequirementInterface should be splitted into 2 interfaces, it still keeps my D really close to 0. And I'm too lazy to fix the diagram.

Overall, the diagram looks super nice. Understanding how polymorphism works is the key to build up and follow the diagram properly.

Wondering if I should transition all of the interactor package (which is consisted of only interfaces that serves the controller) into the controller.

The diagram for DAO is not completed. Controller class will have to wire itself to connect to all other DAO and most other interfaces which is a pain for my eyes and my patience so no. :D 

DAO is weird. From what I understand so far, DAO is a way for you to standalize CRUD feature all over the place. For example: <br/>
Card 1 has its own set of DAO.<br/>
Card 2 has its own set of DAO.<br/>
History has its own set of DAO.<br/>
And with that setup, some DAO can be reused, like Card 1's DAO is quite likely to be reusable for Card 2's DAO.<br/>
But when I need to connect those interface implementations to other classes, it starts to get messy. It breaks I rule in SOLID so terribly because most DAO interfaces contains too many unneccessary features.<br/>
For example, Requirements class use Card's DAO interface but it only needs "Get" function of Card's DAO. It doesn't give a hoot about "Update" or any other crap. Those DAOs surely prevent other class to interfere with the Entities directly but my "Data mapper" can already do the same. And moreover, my "Data mapper" also follow all SOLID rules (Not S rule, fuck that rule srsl, I'm thinking about that S later).
