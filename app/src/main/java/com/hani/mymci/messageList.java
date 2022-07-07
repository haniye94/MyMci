package com.hani.mymci;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class messageList implements ConnectionManager.IConnectionManager {
    private Util util;
    final ArrayList<MessageModel> messageList = new ArrayList<>();

    public messageList(Context context) {
        util = Util.getInstance(context);
        util.getConnectionRequest(this, 0, "https://run.mocky.io/v3/729e846c-80db-4c52-8765-9a762078bc82", null);

    }

    @Override
    public void onConnectionResponse(int requestCode, String response) {

        if (response == null || response.isEmpty()) {
            return;
        }
        if (requestCode == 0) {

            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("messages");
                ParsArrayToModel(jsonArray);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onConnectionFailure(int requestCode, String response) {

    }

    private void ParsArrayToModel(JSONArray jsonArray) {


        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObjectData = jsonArray.getJSONObject(i);
                MessageModel messageModel = new MessageModel();
                messageModel.setTitle(jsonObjectData.getString("title"));
                messageModel.setDescription(jsonObjectData.getString("description"));
                messageModel.setId(jsonObjectData.getString("id"));
                messageModel.setUnread(jsonObjectData.getBoolean("unread"));
                messageList.add(messageModel);

            } catch (Exception ex) {

            }
        }
    }

    public ArrayList arrayList() {
        return messageList;
    }
}
