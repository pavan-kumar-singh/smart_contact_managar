console.log("Script loaded");

// Get the current theme from localStorage
let currentTheme = getTheme();

// Wait until the DOM is fully loaded
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

function changeTheme() {
  // Apply the initial theme
  changePageTheme(currentTheme, "");

  // Get the change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  // Check if the button exists
  if (!changeThemeButton) {
    console.error("Error: Change theme button not found in the DOM.");
    return;
  }

  // Add a click event listener to toggle the theme
  changeThemeButton.addEventListener("click", () => {
    let oldTheme = currentTheme;
    console.log("Change theme button clicked");

    // Toggle theme
    currentTheme = currentTheme === "dark" ? "light" : "dark";

    console.log("New Theme:", currentTheme);

    // Apply the new theme
    changePageTheme(currentTheme, oldTheme);
  });
}

// Save the current theme to localStorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// Retrieve the current theme from localStorage
function getTheme() {
  const theme = localStorage.getItem("theme");
  return theme ? theme.trim() : "light"; // Default to "light"
}

// Apply the theme to the page
function changePageTheme(theme, oldTheme) {
  const htmlElement = document.querySelector("html");

  // Ensure the <html> element exists
  if (!htmlElement) {
    console.error("Error: <html> element not found in the DOM.");
    return;
  }

  // Save the new theme to localStorage
  setTheme(theme);

  // Remove the old theme class
  if (oldTheme) {
    htmlElement.classList.remove(oldTheme.trim());
  }

  // Add the new theme class
  htmlElement.classList.add(theme.trim());

  // Change the button text
  const themeButtonSpan = document.querySelector("#theme_change_button span");

  // Check if the span exists
  if (!themeButtonSpan) {
    console.error("Error: Button span not found.");
    return;
  }

  themeButtonSpan.textContent = theme === "light" ? " Dark" : " Light";
}
