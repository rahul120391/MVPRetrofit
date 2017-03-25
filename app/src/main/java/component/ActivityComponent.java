package component;

import com.example.rahulkumar.mvp.MainActivity;

import Scopes.PerActivity;
import dagger.Component;
import module.ActivityLevelModule;

/**
 * Created by rahulkumar on 03/11/16.
 */

@PerActivity
@Component(modules = ActivityLevelModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
