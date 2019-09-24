# SimulateurBouees

**TODO: Add description**

## Installation

If [available in Hex](https://hex.pm/docs/publish), the package can be installed
by adding `simulateur_bouees` to your list of dependencies in `mix.exs`:

```elixir
def deps do
  [
    {:simulateur_bouees, "~> 0.1.0"}
  ]
end
```

Documentation can be generated with [ExDoc](https://github.com/elixir-lang/ex_doc)
and published on [HexDocs](https://hexdocs.pm). Once published, the docs can
be found at [https://hexdocs.pm/simulateur_bouees](https://hexdocs.pm/simulateur_bouees).


## information

Pour l'instant je pense que le mieux serait d'avoir dans notre main le système qui lance la création de nos bouées et le système de génération des données
Celui ci attendrait les informations des bouées et se chargerait ensuite de créer les données (1 par bouée par seconde) et le tout serait envoyé au module de gestion de la bd (ou de l'émetteur quand on en viendra à la communication)


40 scénarios de données de 120 secondes (donc 120 secondes)

setup du simulateur à définir, les bouées se répartissent les scenar

déplecement : 30 noeuds -­> calcul des changements par le simulateur
