package dev.rollczi.litecommands.example;

import dev.rollczi.litecommands.LiteInvocation;
import dev.rollczi.litecommands.LiteSender;
import dev.rollczi.litecommands.inject.LiteBind;
import dev.rollczi.litecommands.valid.ValidationCommandException;
import dev.rollczi.litecommands.valid.ValidationInfo;
import org.bukkit.entity.Player;

public class PlayerSenderBind implements LiteBind {

    @Override
    public Object apply(LiteInvocation invocation) {
        LiteSender sender = invocation.sender();

        if (!(sender.getSender() instanceof Player)) {
            throw new ValidationCommandException(ValidationInfo.CUSTOM, "Command only for players!");
        }

        return sender.getSender();
    }

}
