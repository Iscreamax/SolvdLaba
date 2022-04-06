package enums;

public enum MainFeatures {

    BRAND {
        public String getValue() {
            return "Brand";
        }
    },
    MEMORY {
        public String getValue() {
            return "Memory";
        }
    },
    BATTERY {
        public String getValue() {
            return "Battery";
        }
    },

    DISPLAY {
        public String getValue() {
            return "Display";
        }
    },
    CPU {
        public String getValue() {
            return "CPU";
        }
    };
    private String value;

    public String getValue() {
        return value;
    }

}

