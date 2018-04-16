package iskills.com.memoriesrefactor.di.activity.utils.fileProviders;

import java.io.File;

/**
 * lennyhicks
 * 4/15/18
 */
public interface FileUtilPresenter {
    File getImageFile();
    byte[] getBytesFromUriString(String uri);
    String getPath(String uriString);
}
