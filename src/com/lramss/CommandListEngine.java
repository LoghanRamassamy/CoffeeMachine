package com.lramss;

import java.util.List;

class CommandListEngine {

    private List<Command> commands;

    CommandListEngine(List<Command> commands){
        this.commands = commands;
    }

    double getTotalCommandSold(){
        double total = 0.0;
        for (Command cmd : this.commands) {
            if(cmd.isValidCommand())
                total += cmd.getDrink().price;
        }
        return total;
    }

    void printCommand(){
        for (Command cmd : this.commands) {
            cmd.printCommand();
        }
    }

    void printCommand(Status status){
        for (Command cmd : this.commands) {
            cmd.printCommand(status);
        }
    }
}
