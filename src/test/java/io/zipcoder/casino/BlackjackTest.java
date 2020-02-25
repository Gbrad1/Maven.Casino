package io.zipcoder.casino;

import static org.junit.Assert.*;

public class BlackjackTest {
    Hand hand = new Hand();
    @Test
    public void blackJackTest() {

        hand.add_card(Card("A", "♡"))
        hand.add_card(Card("J", "♡"))
        self.assertTrue(hand.blackjack())
        hand.add_card(Card("10", "♡"))
        self.assertFalse(hand.blackjack())

        def test_twenty_one_detected(self):
        """Does 'twenty one' get detected correctly?"""
        hand = Hand()
        hand.add_card(Card("A", "♡"))
        hand.add_card(Card("5", "♡"))
        self.assertFalse(hand.twenty_one())
        hand.add_card(Card("5", "♡"))
        self.assertTrue(hand.twenty_one())

        def test_bust_detected(self):
        """Does a 'bust' get detected correctly?"""
        hand = Hand()
        hand.add_card(Card("J", "♡"))
        hand.add_card(Card("5", "♡"))
        self.assertFalse(hand.bust())
        hand.add_card(Card("10", "♡"))
        self.assertTrue(hand.bust())





}