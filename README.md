
# FrameIQ 
#### quality assessment of single frame in a video sequence software.

- module `server` serves backend REST API in JSON format
- module `web` serves frontend GUI

### Run locally
1. Using mvn and plain Java cmd

```
    ${project_root_dir} > mvn clean install
    ${project_root_dir}/target > java -Dspring.profiles.active=local -jar frameIQ.jar
```

2. Using IDE

set `-Dspring.profiles.active=local` to JVM options