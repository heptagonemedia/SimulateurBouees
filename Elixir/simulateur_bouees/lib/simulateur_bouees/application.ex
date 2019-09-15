defmodule SimulateurBouees.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  def start(_type, _args) do
    children = [
      # Starts a worker by calling: SimulateurBouees.Worker.start_link(arg)
      # {SimulateurBouees.Worker, arg}
      SimulateurBouees.Repo,
    ]
    IO.puts("I'M RUNNING BITCH")
    bouee = %SimulateurBouees.Bouee{description: "Premiere bouee", date_debut: DateTime.now("Etc/UTC"), latitude: 50.0, longitude: 50.0}
    IO.puts(bouee.description)
    bouee2 = SimulateurBouees.Bouee.creerBouee("bouee 2", 50.0, 50.0)
    test = bouee2.date_debut
    bidule = DateTime.to_string(elem(test, 1))
    IO.puts(bidule)

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: SimulateurBouees.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
