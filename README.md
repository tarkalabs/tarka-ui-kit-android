## Tarka-ui-kit-android
Android application for building UI components using Jetpack Compose

## List of components

- TUIAppTopBar
- TUIAttachmentUpload
- TUIAvatar
- TUIBadge
- TUIButton
- TUICheckBox
- TUICheckBoxRow
- TUIChip
- TUIDraggableCard
- TUIDivider
- TUIFloatingActionButton
- TUIEmailField
- TUIEmailSubjectField
- TUIIconButton
- TUIInputField
- TUIMobileButtonBlock
- TUIMenuItem
- TUIMediaThumbnail
- TUIMobileOverlayHeader
- TUIMobileOverlayFooter
- TUIMobileOverlayMenu
- TUINavigationRow
- TUIPlayPauseButton
- TUIRadioButton
- TUIRadioButtonRow
- TUISearchBar
- TUISelectionCard
- TUISnackBar
- TUIStatusIndicator
- TUITableCell
- TUITab
- TUITag
- TUITabBar
- TUITextRow
- TUIToggleRow


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

# How to add this library in Project.
This library is developed as maven artifact. So adding it in your project is similar to adding any other public library.

Before we see how to include it in project. We need to generate Github Access token.
This is required as this library is published as private package. And github needs to authenticate you before it can grant you access to private package.

#### Generate New Token
1. Go to https://github.com/settings/tokens/new
2. Please Give appropriate name to this token in **Note** box.
   ![image](https://github.com/tarkalabs/tarka-ui-kit-android/assets/31278093/98daf6e1-ce68-4c3c-a7c7-1f47a1d3ed61)

3. Give `read:packages` permission.
   ![image](https://github.com/tarkalabs/tarka-ui-kit-android/assets/31278093/b068a69f-dcea-4f35-b35b-8dbabf4b3b42)

4. Click on **Generate token** button at bottom. That should generate access token for you. **Note**. Please copy this token before closing or navigating.
   ![image](https://github.com/tarkalabs/tarka-ui-kit-android/assets/31278093/e8611df9-7fc0-486e-8e73-1dfcaa09aa41)


#### Saving Github access token and username as Env variable.
If you are using Bash. then you will have to update `.bash_profile` file.
And if you are using zsh. then you will have to update `.zshrc` file.
Both the files can be found in home directory of your mac. (Command to go to home dir. `cd ~`)

once you open that file. you will need to export your github username and github token in file mentioned above and save.

Example:
```
export GITHUB_USER=kalpeshp0310
export GITHUB_TOKEN=d5ce3750293e15baf41a177e91b6d267005007a9
```
Note: You will need to restart your android studio after this for Gradle to read this env variables.

#### Update to level of your `build.gradle` file.

Add Package specific github maven repository url. in your Root level build.gradle under repository section.
```
maven {
      url = "https://maven.pkg.github.com/tarkalabs/eam360-common-library-android"
      credentials {
        username = System.getenv('GITHUB_USER')
        password = System.getenv('GITHUB_TOKEN')
      }
    }
```

Example:
![image](https://github.com/tarkalabs/tarka-ui-kit-android/assets/31278093/a0fc5eec-58e8-41fd-8414-b2f1130c3dc5)


#### Updating module specific build.gradle file.
Add dependency in your module level build.gradle file. i.e in `app/build.gradle` file.
```
implementation("com.tarkalabs:tarkaui:1.0.0")
implementation("com.tarkalabs:tarkaicons:1.0.0")
```

That's it. you are done. Do a gradle sync and you will be able to use the library in your project.

## License

TarkaUi Kit is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

