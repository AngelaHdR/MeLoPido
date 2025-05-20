package com.fpmislata.MeLoPido.domain.usecase.group.command;

import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;

public interface InsertGroup {
    String insert(GroupCommand group);
}
