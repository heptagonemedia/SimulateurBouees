use Mix.Config

config :simulateur_bouees, SimulateurBouees.Repo,
  database: "simulateur_bouees_repo",
  username: "postgres",
  password: "mission",
  hostname: "localhost",
  port: 5432

config :simulateur_bouees, ecto_repos: [SimulateurBouees.Repo]
