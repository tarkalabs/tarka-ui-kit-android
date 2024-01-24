## Tarka-ui-kit-android
Android application for building UI components using Jetpack Compose

## List of components

- TUIAvatar
- TUIBadge
- TUIButton
- TUIFloatingActionButton
- TUIIconButton
- TUIInputField
- TUIToggleRow
- TUIDraggableCard
- TUISelectionCard
- TUICheckBox
- TUIRadioButton
- TUIRadioButtonRow
- TUIFloatingNavBar
- TUIFloatingTab
- TUITab
- TUITabBar
- TUIAttachmentUpload
- TUINavigationRow
- TUISearchBar
- TUISnackBar
- TUIStatusIndicator
- TUITextRow
- TUIAppTopBar
- TUIChip
- TUIMobileButtonBlock
- TUIMenuItem
- TUIMobileOverlayHeader
- TUIMobileOverlayFooter
- TUISelectionCard
- TUITag
- TUIPlayPauseButton
- TUIMultiLevelSelectorHeader
- TUITableCell
- TUIEmailField
- TUIEmailSubjectField
- TUIMediaThumbnail

## TODO

1. move the dimension to a dimens.xml resources file (need consistent naming with the designers).


# TarkaUI Kit

TarkaUI Kit is a versatile Design Library built on top of Jetpack Compose, based on a design system using Atomic Design principles, designed to simplify and enhance the creation of UI elements in your Android applications. With a focus on flexibility, customization, and ease of use, TarkaUi Kit empowers developers to create modern and visually appealing user interfaces effortlessly.

## Features

- **Pre-built UI Components:** TarkaUi Kit provides a collection of pre-built UI components, including buttons, cards, dialogs, and more. These components are designed to seamlessly integrate into your application, they all start with `TUI`, this will reduce the development time for common UI elements.

- **Customization:** Each UI component is highly customizable, allowing you to tailor the appearance and behavior to match your application's unique design requirements. Modify colors, shapes, and animations with ease, ensuring a cohesive and polished look for your app.

- **Responsive Design:** TarkaUi Kit incorporates responsive design principles, ensuring that your UI elements adapt seamlessly to different screen sizes and orientations. Create consistent and user-friendly experiences across a variety of devices.

- **Theming Support:** Leverage TarkaUi Kit's theming support to maintain a cohesive visual identity throughout your application. Switch between light and dark themes effortlessly, and define your custom theme attributes to match your brand guidelines.

- **Compatibility:** TarkaUi Kit is built on top of Jetpack Compose, ensuring compatibility with the latest Android development standards. Seamlessly integrate TarkaUi Kit into your existing Jetpack Compose projects and stay up-to-date with the latest Android SDK releases.

## Getting Started

### Installation

To integrate TarkaUi Kit and Tarka Icons into your Android project, add the following dependencies in your app-level `build.gradle` file:

```kotlin
implementation("com.tarkalabs:tarkaui:1.0.0")
implementation("com.tarkalabs:tarkaicons:1.0.0")
```

You'll need also to mention the repository that you will get it from, we are using github package, make sure you include this code where you are mentionning your repositories 

```kotlin
repositories {
    maven(url = "https://maven.pkg.github.com/tarkalabs/tarka-ui-kit-android")
}
```

## License

TarkaUi Kit is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

