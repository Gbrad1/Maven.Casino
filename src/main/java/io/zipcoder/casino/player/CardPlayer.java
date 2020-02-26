package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;

abstract class CardPlayer extends Player {
    public abstract void drawCard(Card card);

    public abstract void playerTurn();
}
