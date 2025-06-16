{ pkgs, ... }:

{
  packages = with pkgs; [
    texliveFull
    just
    tectonic
  ];

  enterShell = ''
    just --version
    tectonic --version
    just start
  '';
}
