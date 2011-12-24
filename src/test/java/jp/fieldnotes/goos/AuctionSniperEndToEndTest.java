package jp.fieldnotes.goos;

import jp.fieldnotes.goos.sniper.ApplicationRunnner;
import jp.fieldnotes.goos.sniper.FakeAuctionServer;

import org.junit.After;
import org.junit.Test;

public class AuctionSniperEndToEndTest {

	private final FakeAuctionServer auction = new FakeAuctionServer(
			"item-54321");

	private final ApplicationRunnner application = new ApplicationRunnner();

	@Test
	public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
		auction.startSellingItem();
		application.startBiddingIn(auction);
		auction.hasReceivedJoinRequestSniper();
		auction.announceClosed();
		application.showsSniperHasLostAuction();
	}

	@After
	public void stopAuction() {
		auction.stop();
	}

	@After
	public void stopApplication() {
		application.stop();
	}
}
