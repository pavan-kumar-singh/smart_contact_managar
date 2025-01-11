console.log("Script loaded");

// Change theme work
let currentTheme = getTheme();

// Initial setup when DOM is loaded
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

// Function to handle theme changes
function changeTheme() {
  // Set the theme to the web page initially
  changePageTheme(currentTheme, "");

  // Set the listener to the change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  if (!changeThemeButton) {
    console.error("Theme change button (#theme_change_button) not found.");
    return; // Stop further execution if the button is missing
  }

  changeThemeButton.addEventListener("click", (event) => {
    const oldTheme = currentTheme;
    console.log("Change theme button clicked");

    // Toggle between dark and light themes
    currentTheme = currentTheme === "dark" ? "light" : "dark";

    console.log("Current Theme:", currentTheme);

    // Apply the theme changes
    changePageTheme(currentTheme, oldTheme);
  });
}

// Function to set theme in local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// Function to get theme from local storage
function getTheme() {
  const theme = localStorage.getItem("theme");
  return theme || "light"; // Default to "light" if no theme is stored
}

// Function to apply the theme to the current page
function changePageTheme(theme, oldTheme) {
  // Update local storage with the current theme
  setTheme(theme);

  const htmlElement = document.querySelector("html");

  // Remove the old theme class if it exists
  if (oldTheme) {
    htmlElement.classList.remove(oldTheme);
  }

  // Add the new theme class
  htmlElement.classList.add(theme);

  // Change the text of the button
  const changeThemeButton = document.querySelector("#theme_change_button");
  
  if (!changeThemeButton) {
    console.error("Theme change button (#theme_change_button) not found.");
    return; // Stop further execution if the button is missing
  }

  const spanElement = changeThemeButton.querySelector("span");
  if (!spanElement) {
    console.error("Span element inside the theme change button not found.");
    return; // Stop further execution if the <span> is missing
  }

  spanElement.textContent = theme === "light" ? "Dark" : "Light";
}
