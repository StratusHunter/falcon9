# falcon9
Searches for Falcon 9 launches using the SpaceX API https://github.com/r-spacex/SpaceX-API

### Branch Management:
Used GitFlow branching pattern and rebased my feature branches before merging into develop.
I have left my feature branches on the remote in their non rebased state.

### Process Breakdown:
1. Researched the API. Used postman to experiment and build the request I needed. Found I could reduce the amount of data returned in the model to optimize bandwidth.
2. Began coding a basic Retrofit example to proove I could get the request I made in postman working in Android.
3. Researched coroutines used in conjunction with Retrofit and converted the code across. Abstracted the functionality to decouple Retrofit dependency.
4. For super efficiency I thought it best to use the provided pagination from the API. Followed some basic Paging 3 tutorials and got it up and running with minimal UI.
5. Now to work on the shiny stuff. Added loading states for the pagination process and for the initial load. Also added a retry button if either of these loads failed. Turns out this was not easy to test using the emulator despite the networking options, so loaded up onto a phone to check the in progress pagination would display it's loading and error states correctly.
6. Finally just finished off my view holders for the recycler view. Used Glide for async image loading. Discovered a bug where the patch image strings sometimes come down as null. Abstracted the image loading so Glide is decoupled.
