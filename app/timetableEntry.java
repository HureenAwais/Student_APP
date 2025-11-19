public class timetableEntry {

        private String time;
        private String moduleCode;
        private String moduleName;
        private String location;

        public timetableEntry(String time, String moduleCode, String moduleName, String location) {
            this.time = time;
            this.moduleCode = moduleCode;
            this.moduleName = moduleName;
            this.location = location;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getModuleCode() {
            return moduleCode;
        }

        public void setModuleCode(String moduleCode) {
            this.moduleCode = moduleCode;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
}


