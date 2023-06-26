import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Role;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args){
        JDABuilder jdaBuilder = JDABuilder.createDefault("ODQ3OTA5NjI5MjE1ODk5NjY4.YLE7YQ.mYI1_movlV1yKzEgT8xxtqeOsZY");
        JDA jda = null;
        PingPong pingPong = new PingPong();
        jdaBuilder.addEventListeners(pingPong);
        Invite invite = new Invite();
        jdaBuilder.addEventListeners(invite);
        RoleReactions roleReactions = new RoleReactions();
        jdaBuilder.addEventListeners(roleReactions);
        jdaBuilder.setActivity(Activity.watching("ba oli, dc nu inveti?"));

        try{
            jda = jdaBuilder.build();
        }catch (LoginException e) {
            e.printStackTrace();
        }
        try{
            jda.awaitReady();
        }
        catch (InterruptedException e)
        {e.printStackTrace();}



    }
}
