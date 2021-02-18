package ram.ramires.messenger.activityEntrance;

import androidx.annotation.NonNull;

import io.reactivex.Observable;

public class HawkKeyValueStorage implements KeyValueStorage {
    @Override
    public void saveToken(@NonNull String token) {

    }

    @NonNull
    @Override
    public String getToken() {
        return null;
    }

    @Override
    public void saveUserName(@NonNull String userName) {

    }

    @NonNull
    @Override
    public Observable<String> getUserName() {
        return null;
    }

    @Override
    public void saveWalkthroughPassed() {

    }

    @Override
    public boolean isWalkthroughPassed() {
        return false;
    }
}
