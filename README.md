# VideoPlayerComparison

## About the project

Goal of this project is to identify why Exoplayer flickering occurs within ExoPlayerFragment.kt

## Problems of Exoplayer

On initial launch of PlayerView, there are two flickers that occurs: black screen and resizing flicker. Below is a video showcasing the problem and what should be the expected. Results are compared with `VideoView` usage.

| Current result (Exoplayer)      | Expected result (VideoView) |
| ----------- | ----------- |
| [Exoplayer.mp4](https://user-images.githubusercontent.com/14857616/189907859-ed8b6141-6a82-4d80-a93b-3100c36fb335.mp4) | [VideoView.mp4](https://user-images.githubusercontent.com/14857616/189907776-3aa4ec8b-af68-4a63-b4a6-85bd5b434634.mp4) |

### Black screen flicker
StackOverflow solutions for fixing black screen issue is to use `setZOrderOnTop(true)` and `surfaceHolder.setFormat(PixelFormat.Translucent)`. However in this sample app black screen flicker remains not fixed even when these settings are set. Also there were suggestions to set `surfaceView.setZOrderMediaOverlay(true)`, but no luck.

### Resize flicker

To my knowledge resize flickering occurs, because Exoplayer on initial launch has `width` set to `match_parent` and `height` set to `0dp` and once `MediaItem` is set, then it adjusts the size according to the video dimensions. Thus there is this wonky resizing flickering too.

## Question

What can be done to fix black screen and resizing flickering issues?






