package jp.fieldnotes.goos.sniper;

public class ApplicationRunnner {

	public static final String SNIPER_ID = "sniper";

	public static final String SNIPER_PASSWORD = "sniper";

	public static final String STASUS_JOINING = "status_joining";

	public static final String STATUS_LOST = "status_lost";

	private AuctionSniperDriver driver;

	public void startBiddingIn(final FakeAuctionServer auction) {
		Thread thread = new Thread("Test Application") {

			@Override
			public void run() {
				try {
					Main.main("", "", "", auction.getItemId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		};
		thread.setDaemon(true);
		thread.start();
		driver = new AuctionSniperDriver(1000);
		driver.showSniperStatus(STASUS_JOINING);

	}

	public void showsSniperHasLostAuction() {
		driver.showsSnoperStatus(STATUS_LOST);
	}

	public void stop() {
		if (driver != null) {
			driver.dispose();
		}
	}
}
