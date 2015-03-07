package nl.tue.id.oocsi.client.protocol;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import nl.tue.id.oocsi.client.socket.Base64Coder;

abstract public class Handler {

	final public void send(String sender, String data, String timestamp, String channel, String recipient) {
		try {

			// parse data from string
			ByteArrayInputStream bais = new ByteArrayInputStream(Base64Coder.decode(data));
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object outputObject = ois.readObject();
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) outputObject;

			// parse timestamp
			long ts = System.currentTimeMillis();
			try {
				ts = Long.parseLong(timestamp);
			} catch (Exception e) {
				// do nothing
			}

			// forward event
			receive(sender, map, ts, channel, recipient);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	abstract public void receive(String sender, Map<String, Object> data, long timestamp, String channel,
			String recipient);
}
