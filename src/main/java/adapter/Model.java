package adapter;

import android.net.Uri;

public class Model {

        private String name;
        private Uri uri;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Uri getUri() {
            return uri;
        }

        public void setUri(Uri uri) {
            this.uri = uri;
        }
}
