package Drivers;

public enum Browser {
    CHROME {
        @Override
        public AbstractDriver getFactory() {
            return new ChromeFactory();
        }
    },
    EDGE {
        @Override
        public AbstractDriver getFactory() {
            return new EgdeFactory();
        }
    };

    public abstract AbstractDriver getFactory();
}
