module.exports = {
  printWidth: 150,
  tabWidth: 4,
  useTabs: false,
  singleQuote: true,
  semi: true,
  arrowParens: "avoid",
  trailingComma: "es5",
  bracketSpacing: true,
  endOfLine: "lf",
  overrides: [
    {
      files: ["*.html", "*.hbs"],
      options: {
        proseWrap: "preserve",
        printWidth: 250,
        singleQuote: false,
      },
    },
    {
      files: ["*.css", "*.sass", "*.scss", "*.less", "*.svg"],
      options: {
        singleQuote: false,
        tabWidth: 2,
      },
    },
    {
      files: "*.json",
      options: {
        singleQuote: false,
        printWidth: 400,
        tabWidth: 2,
      },
    },
  ],
};
