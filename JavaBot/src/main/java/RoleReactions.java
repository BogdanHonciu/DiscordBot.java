import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class RoleReactions extends ListenerAdapter {

    final long channelId = 848166194825003028L;
    final long roleID = 848166590977278012L;
    HashMap<Long, Long> reactionToRoleID = new HashMap<>();
    public RoleReactions(){
        reactionToRoleID.put(848205197879934987L, 848166590977278012L); //eye
    }
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){
        if(e.getTextChannel().getIdLong() == channelId){
            Long roleID =reactionToRoleID.get(e.getReactionEmote().getIdLong());
            //System.out.println(e.getReactionEmote().getIdLong());
            if(roleID == null){
                return;
            }

            e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

        }
    }
    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e){
        if(e.getTextChannel().getIdLong() == channelId){
            Long roleID =reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if(roleID == null){
                return;
            }
            e.getGuild().removeRoleFromMember(e.getUserId(),e.getJDA().getRoleById(roleID)).queue();
        }
    }
}