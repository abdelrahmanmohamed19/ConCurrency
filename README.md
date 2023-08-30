# ConCurrency - Android App <img height="40" src="https://user-images.githubusercontent.com/25181517/117269608-b7dcfb80-ae58-11eb-8e66-6cc8753553f0.png" />

[<img src="/screenShots/fba33f19-3630-4656-ab4e-bfbf3a3853d3.jpg" align="center"
width="200"
    hspace="10" vspace="10">](/screenShots/fba33f19-3630-4656-ab4e-bfbf3a3853d3.jpg)



## $\color{green}{About}$

The currency conversion app aims to provide users with real-time and accurate currency
conversion rates. It will support a wide range of currencies and offer a user-friendly interface.
The app will be developed for multiple platforms, including web, Android ,and iOS.


## $\color{green}{Features}$


The android app lets you:

+ convert between different currencies, can enter the amount they want to convert, select the source currency, and choose the target currency. The app will display the converted amount based on the current exchange rate.

+ compare between multiple currencies by enter the amount they want to convert, select the source currency, and choose multiple target currencies. The app will display the compared amount based on the current exchange rate.

+ The app will fetch real-time exchange rates based on the selected source currency.

+ mark specific currencies as their favorites for quick access. The app will provide an option to save and manage a list of frequently used currencies.




## $\color{green}{Technical}$

- Architecture: The app follows the MVVM (Model-View-ViewModel) architecture, which promotes a clear separation of concerns and facilitates easier testing and scalability.

- Clean Architecture: The app is structured using the Clean Architecture principles, separating the application into distinct layers - Presentation, Domain, and Data - to achieve modularity and maintainability.

- User Interface: The user interface is built using Jetpack Compose, a modern Android UI toolkit that simplifies and accelerates UI development through a declarative approach.

- Navigation: The Navigation component is employed to manage navigation within the app. It provides a consistent and predictable way to navigate between different screens.

- UI Components: The app features a Tab Layout for organizing content and enhancing user navigation between different sections.

- Database: Room Database is utilized to handle local data persistence. This provides a robust and efficient way to manage and query data locally.

- Network Communication: Retrofit is employed for handling network requests. It provides a convenient and efficient way to communicate with APIs and retrieve data from remote servers.

- Concurrency: Coroutines are used to manage asynchronous operations and simplify concurrency handling. They enable smoother execution of tasks without blocking the main thread.

- Dependency Injection: Hilt is utilized for dependency injection. It simplifies the process of managing dependencies and enhances the testability and maintainability of the codebase.

- Testing & Error Handling:  The app employs unit tests to validate code components in isolation, Network errors are gracefully managed, with Retrofit checking HTTP responses and displaying user-friendly messages, exception handling prevents crashes by catching and logging unexpected errors, enhancing app stability.

- Image Loading: Images are loaded efficiently using the Coil library, which handles image caching and loading with ease.

- Animations: Lottie animations are integrated into the app to provide visually appealing and interactive animations that enhance the user experience.



## $\color{green}{Screenshots}$

[<img src="/screenShots/convert.jpg" align="left"
width="200"
    hspace="10" vspace="10">](/screenShots/convert.jpg)
    
[<img src="/screenShots/compare.jpg" align="center"
width="200"
    hspace="10" vspace="10">](/screenShots/compare.jpg)

[<img src="/screenShots/favorite.jpg" align="left"
width="200"
    hspace="10" vspace="10">](/screenShots/favorite.jpg)
    [<img src="/screenShots/dialog.jpg" align="center"
width="200"
    hspace="10" vspace="10">](/screenShots/dialog.jpg)

## $\color{red}{Permissions}$

ConCurrency requires the following permissions:
- Full Network Access.

The network access permissions are made use of for currency converter, comparison and Life exchange rates APIs.

## $\color{blue}{Authors}$

- [@Mahmoudadel17](https://www.github.com/Mahmoudadel17)
- [@AbdelrahmanMohamed](https://github.com/abdelrahmanmohamed19)
- [@EmanMaged](https://github.com/Amona12345)
